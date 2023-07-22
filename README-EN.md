# NestedSetDemo in Java
##### 📖 English Documentation | [📖 中文文档](README.md)

An implementation of Nested Set nested set design in Java. 
The implementation mainly focuses on the processing of the data before it is entered into the database, solving the problem of how to assign left and right values and depth to the data.

# Usage
1. com.github.nestedset.Start class, in the java environment directly compiled to execute the main method, you can see the correct output; ... is the absolute path to your project; the example is for windows, linux is supported!
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
2. If you are also a file directory structure, NestedSetsUtil can be used directly; otherwise, please modify based on it. For example, the input parameter is a specified data set that needs to be traversed. Also use the stack as a container to store temporary data.

3. Please note that there are two TODOs in the source code that need to be adjusted, one is in Start#main(), after getting the result of the data, it needs to be put into the library; the other is in Start#getFileNestedSetsDemoList(), the treeId needs to be assigned according to the business logic; you can adjust it to be a String type to give the UUID.

For more information, see [Implementation of nested set design of SQL with Java - Preorder Tree Traversal](https://bobotheknight.github.io/implement-SQL-nested-sets-in-Java-en/)
