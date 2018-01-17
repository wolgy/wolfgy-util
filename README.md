# wolfgy-util
Util collection of mine.我的个人工具类集合。

## Java相关工具类
#### [Excel相关工具类](https://github.com/wolgy/wolfgy-util/blob/master/src/main/java/com/wolfgy/util/java/ExcelUtil.java)
1. deleteSpecifiedRows(String inputFilePath,String outputFilePath,List<Integer> rowList,int sheetIndex) throws Exception  
**作用:** 删除excel文件中指定行（支持多行同时删除）  
**示例:** 传入参数`inputFilePath="C:\\test.xlsx"`，`outputFilePath="C:\\test-handled.xlsx"`，`rowList={2,3}`，`sheetIndex=0`。则本方法将会读取路径为`C:\\test.xlsx`的Excel文件，删除第1个sheet页的第2行和第3行，并将处理好的新Excel输出至`C:\\test-handled.xlsx`。  
**参考:** [利用poi开源jar包操作Excel时删除行内容与直接删除行的区别](http://blog.csdn.net/b_h_l/article/details/8255247)  
## Android相关工具类
#### [ResourceUtil/R文件相关工具类](https://github.com/wolgy/wolfgy-util/blob/master/src/main/java/com/wolfgy/util/android/ResourceUtil.java)
1. getResourceFieldName(Class<?> r , String resourceType , int value)  
**作用:** 获取R文件中资源值对应的字段名。  
**示例:** `drawable`文件夹下名为`ic_catelog_0006010`的资源文件，
在`R`文件中生成的资源字段为`public static final int ic_catelog_0006010=0x7f070061`。
调用本方法传入`resourceType="drawable"`,`value=0x7f070061`,方法返回`"ic_catelog_0006010"`。
2. getResourceFieldValue(Class<?> r , String resourceType , String name)  
**作用:** 获取R文件中资源字段名对应的值。  
**示例:** `drawable`文件夹下名为`ic_catelog_0006010`的资源文件，
在`R`文件中生成的资源字段为`public static final int ic_catelog_0006010=0x7f070061`。
调用本方法传入`resourceType="drawable"`,`name="ic_catelog_0006010"`,方法返回`0x7f070061`。

#### [GridViewUtil/GridView相关工具类](https://github.com/wolgy/wolfgy-util/blob/master/src/main/java/com/wolfgy/util/android/GridViewUtil.java)
1. setGridViewHeightBasedOnChildren(GridView gridView)  
**作用:** 设置GridView高度(在调用setAdapter()方法后调用此方法)。可用于解决GridView与ListView/RecyclerView等可滑动视图嵌套时只显示一行的问题。  
**整理自:** [利用反射获取GridView的高度](http://blog.csdn.net/jys1115/article/details/46045211)
