package com.github.nestedset;

import java.io.File;
import java.util.*;

public class NestedSetsUtil {
    /**
     * 使用深度优先遍历目录，返回Map，用来支持嵌套集初次入库。
     *
     * @param root 需要遍历的目录
     * @return Map<file对象，Object对象>
     **/
    public static Map<File, NestedSetObj> dfs2NestedSets(File root) {
        if (root == null) {
            return new HashMap<>(0);
        }

        //记录深度 每次出栈-1, 每次入栈+1
        long depth = 0L;
        //左右值
        long index = 1L;
        Deque<File> stack = new ArrayDeque<>();
        stack.push(root);

        //全局的对象集合，同时也表示了这个对象是否入栈过。
        Map<File, NestedSetObj> map = new LinkedHashMap<>();
        //根目录，直接给值
        NestedSetObj rootObj = new NestedSetObj(index++, depth, root.getAbsolutePath());
        map.put(root, rootObj);

        while (!stack.isEmpty()) {
            File cur = stack.pop();
            depth--;
            File[] files = cur.listFiles();
            if (files != null) {
                //找到下一个节点就执行
                for (File next : files) {
                    //下一个节点如果没有被访问过就执行
                    if (!map.containsKey(next)) {
                        //当前节点和下一个节点入栈
                        depth++;
                        stack.push(cur);
                        depth++;
                        stack.push(next);
                        //每首次访问，节点赋值left
                        NestedSetObj obj = new NestedSetObj(index++, depth, next.getAbsolutePath());
                        boolean leaf = !next.isDirectory();
                        boolean emptyDirLeaf = next.listFiles() != null && next.listFiles().length == 0;
                        //叶子节点或空目录直接赋right值
                        if (leaf || emptyDirLeaf) {
                            obj.setRight(index++);
                        }
                        map.put(next, obj);
                        break;
                    }
                }

                //判断是否需要给叶子节点的right赋值；我们认为，只有当前目录下，所有子一级的数据都有了right值，则当前目录可以被赋值。
                long min = Long.MAX_VALUE;

                for (File file : files) {
                    NestedSetObj childObject = map.get(file);
                    if (childObject == null) {
                        min = 0L;
                        break;
                    }
                    min = Math.min(min, childObject.getRight());
                }

                //给非叶子节点的right赋值;当一级子节点都有了right值，index 加一即为当前节点的right值。
                if (min > 0L && Long.MAX_VALUE != min) {
                    NestedSetObj curObj = map.get(cur);
                    if (curObj.right == 0L) {
                        curObj.setRight(index++);
                    }
                }
            }
        }
        //根目录的右值=节点数量*2
        rootObj.setRight(map.size() * 2L);
        return map;
    }

    /**
     *  文件嵌套集对象，业务无关  
     */

   public static class NestedSetObj {
        private long left;
        private long right;
        private long depth;
        private String path;

        public NestedSetObj() {
        }

        public NestedSetObj(long left, long depth, String path) {
            this.left = left;
            this.depth = depth;
            this.path = path;
        }

        public long getLeft() {
            return left;
        }

        public void setLeft(long left) {
            this.left = left;
        }

        public long getRight() {
            return right;
        }

        public void setRight(long right) {
            this.right = right;
        }

        public long getDepth() {
            return depth;
        }

        public void setDepth(long depth) {
            this.depth = depth;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }

}