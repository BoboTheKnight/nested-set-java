package com.github.nestedset;

import com.github.nestedset.NestedSetsUtil.NestedSetObj;
import java.io.File;
import java.util.*;
import java.util.Map.Entry;


public class Start {

    public static void main(String[] args) {
        //当前项目的绝对路径
        String projectPath = new File("").getAbsolutePath();
        String rootPath = projectPath + File.separator + "src" + File.separator + "main" + File.separator + "resources" ;
        System.out.println(rootPath);
        System.out.println("=======================================");

        //执行和输出构造结果
        Map<File, NestedSetObj> fileNestedSetObjMap = runAndOutputPathNestedSets(rootPath);
        System.out.println("=======================================");

        //根据嵌套集，组织入库实体数据
        List<FileNestedSetsDemo> dataList = getFileNestedSetsDemoList(fileNestedSetObjMap);
        for (FileNestedSetsDemo fileNestedSetsDemo : dataList) {
            System.out.println(fileNestedSetsDemo.toString());
        }
        //TODO 入库逻辑
        //batchInsert(dataList);
    }

    private static List<FileNestedSetsDemo> getFileNestedSetsDemoList(Map<File, NestedSetObj> fileNestedSetObjMap) {
        List<FileNestedSetsDemo> fileNestedSetsDemos = new ArrayList<>();
        for (Entry<File, NestedSetObj> entry : fileNestedSetObjMap.entrySet()) {
            File file = entry.getKey();
            NestedSetObj obj = entry.getValue();
            FileNestedSetsDemo fileNestedSetsDemo = new FileNestedSetsDemo();
            fileNestedSetsDemo.setId(UUID.randomUUID().toString());
            fileNestedSetsDemo.setPath(obj.getPath());
            fileNestedSetsDemo.setType(getByFile(file));
            fileNestedSetsDemo.setSize((double) file.length());
            // TODO 每次执行需要改此处的treeId，可以根据业务制定。
            fileNestedSetsDemo.setTreeId(1L);
            fileNestedSetsDemo.setLeftIndex(obj.getLeft());
            fileNestedSetsDemo.setRightIndex(obj.getRight());
            fileNestedSetsDemo.setDepth(obj.getDepth());
            fileNestedSetsDemos.add(fileNestedSetsDemo);
        }
        return fileNestedSetsDemos;
    }

    private static Map<File, NestedSetObj> runAndOutputPathNestedSets(String path) {
        Map<File, NestedSetObj> fileNestedSetObjMap = NestedSetsUtil.dfs2NestedSets(new File(path));

        System.out.println("depth  left_index|||path|||right_index");
        for (NestedSetObj value : fileNestedSetObjMap.values()) {
            System.out.println(value.getDepth() + "  " + value.getLeft() + "|||" + value.getPath() + "|||" + value.getRight());
        }
        return fileNestedSetObjMap;
    }

    private static String getByFile(File file) {
        return file.isDirectory() ? "DIRECTORY" : "FILE";
    }

}
