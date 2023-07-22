# NestedSetDemo in Java

##### [📖 English Documentation](README-EN.md) | 📖 中文文档


用Java实现 Nested Set 嵌套集的设计。该实现主要是聚焦在数据入库前的处理，解决了如何给数据赋左右值和深度的问题。

# 使用方式
1. com.github.nestedset.Start 类，在java环境中直接编译执行main方法，可以看到正确输出；...为你项目的绝对路径；示例是windows，支持linux
```text
...\resources
=======================================
depth  left_index|||path|||right_index
0  1|||...\resources|||20
1  2|||...\resources\bootstrap.properties|||3
1  4|||...\resources\data|||7
2  5|||...\resources\data\table_design|||6
1  8|||...\resources\logback-spring.xml|||9
1  10|||...\resources\mapper|||19
2  11|||...\resources\mapper\AMapper.xml|||12
2  13|||...\resources\mapper\server|||16
3  14|||...\resources\mapper\server\ServerMapper.xml|||15
2  17|||...\resources\mapper\source|||18
=======================================
FileNestedSetsDemo[id='51be39c1-0420-44ab-ab39-741f9195cc86', path='...\resources', type='DIRECTORY', size=4096.0, treeId=1, leftIndex=1, rightIndex=20, depth=0]
FileNestedSetsDemo[id='a0834a2f-b5b7-4782-a092-b71f94d21a7f', path='...\resources\bootstrap.properties', type='FILE', size=0.0, treeId=1, leftIndex=2, rightIndex=3, depth=1]
FileNestedSetsDemo[id='4a7fc520-a763-462a-942b-7549785f6b17', path='...\resources\data', type='DIRECTORY', size=0.0, treeId=1, leftIndex=4, rightIndex=7, depth=1]
FileNestedSetsDemo[id='fbfd12ae-3f25-4417-919f-f88f8e017804', path='...\resources\data\table_design', type='FILE', size=0.0, treeId=1, leftIndex=5, rightIndex=6, depth=2]
FileNestedSetsDemo[id='34612b1e-f7a6-4d02-99fa-3dac6d084fe7', path='...\resources\logback-spring.xml', type='FILE', size=0.0, treeId=1, leftIndex=8, rightIndex=9, depth=1]
FileNestedSetsDemo[id='6b8eb084-8bcc-4764-9cb9-f7c12669fbc4', path='...\resources\mapper', type='DIRECTORY', size=0.0, treeId=1, leftIndex=10, rightIndex=19, depth=1]
FileNestedSetsDemo[id='8e0f2aaf-998f-435a-a760-b1c153ee54ab', path='...\resources\mapper\AMapper.xml', type='FILE', size=0.0, treeId=1, leftIndex=11, rightIndex=12, depth=2]
FileNestedSetsDemo[id='6b144609-4cd2-4f62-a58c-ed265da4fffc', path='...\resources\mapper\server', type='DIRECTORY', size=0.0, treeId=1, leftIndex=13, rightIndex=16, depth=2]
FileNestedSetsDemo[id='4bd91ca9-5ec8-44fe-ad42-2bcfe02c0d2f', path='...\resources\mapper\server\ServerMapper.xml', type='FILE', size=0.0, treeId=1, leftIndex=14, rightIndex=15, depth=3]
FileNestedSetsDemo[id='b6e8e470-37ff-4679-8d72-2f1535426294', path='...\resources\mapper\source', type='DIRECTORY', size=0.0, treeId=1, leftIndex=17, rightIndex=18, depth=2]
```

2. 如果你也是文件目录结构，NestedSetsUtil可以直接拿去用；否则请基于其进行修改。例如入参是指定的数据集合，需要遍历。同样使用栈作为容器存储临时数据。

3. 请注意源码中有两处TODO需要调整，一处是 Start#main() 中，得到数据结果后，需要入库；另一处是 Start#getFileNestedSetsDemoList() 中，treeId 需要根据业务逻辑赋值；你也可自行调整为String类型，给UUID.

建表语句与更多说明，见[用Java实现SQL的嵌套集设计 - 先序树遍历](https://bobotheknight.github.io/zh-CN/implement-SQL-nested-sets-in-Java-zh/)
