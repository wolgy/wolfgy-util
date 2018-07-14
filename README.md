# wolfgy-util
Util collection of mine.我的个人工具类集合。

## Java相关工具类
#### [Excel工具类-ExcelUtils](https://github.com/wolgy/wolfgy-util/blob/master/src/main/java/com/wolfgy/util/java/ExcelUtils.java)
1. deleteSpecifiedRows(String inputFilePath,String outputFilePath,List<Integer> rowList,int sheetIndex) throws Exception  
**作用:** 删除excel文件中指定行（支持多行同时删除）  
**示例:** 传入参数`inputFilePath="C:\\test.xlsx"`，`outputFilePath="C:\\test-handled.xlsx"`，`rowList={2,3}`，`sheetIndex=0`。则本方法将会读取路径为`C:\\test.xlsx`的Excel文件，删除第1个sheet页的第2行和第3行，并将处理好的新Excel输出至`C:\\test-handled.xlsx`。  
**参考:** [利用poi开源jar包操作Excel时删除行内容与直接删除行的区别](http://blog.csdn.net/b_h_l/article/details/8255247)  

#### [Java Bean工具类-ConvenientBeanUtils](https://github.com/wolgy/wolfgy-util/blob/master/src/main/java/com/wolfgy/util/java/ConvenientBeanUtils.java)
1. getNullPropertyNames(Object obj)  
**作用:** 获取传入Bean对象中值为空的属性名。 
2. getNotNullPropertyNames(Object obj)  
**作用:** 获取传入Bean对象中值不为空的属性名。 
3. copyPropertiesIgnoreSpecified(Object source, Object target, @Nullable String ignoreProperties)  
**作用:** 拷贝属性到目标对象，同时排除指定属性。
4. copyPropertiesIgnoreNull(Object source, Object target)  
**作用:** 拷贝非空属性到目标对象。
5. copyPropertiesIgnoreNullAndSpecified(Object source, Object target,@Nullable String ignoreProperties)  
**作用:** 拷贝非空属性到目标对象，同时排除指定属性。	
6. copyPropertiesIgnoreNotNullInTarget(Object source, Object target)  
**作用:** 只从source中拷贝target中属性值为空的字段。
7. copyPropertiesIgnoreNotNullInTargetAndSpecified(Object source, Object target,@Nullable String ignoreProperties)   
**作用:** 只从source中拷贝target中属性值为空的字段。


## Android相关工具类
#### [ResourceUtil/R文件相关工具类-ResourceUtils](https://github.com/wolgy/wolfgy-util/blob/master/src/main/java/com/wolfgy/util/android/ResourceUtils.java)
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

#### [GridViewUtil/GridView相关工具类-GridViewUtils](https://github.com/wolgy/wolfgy-util/blob/master/src/main/java/com/wolfgy/util/android/GridViewUtils.java)
1. setGridViewHeightBasedOnChildren(GridView gridView)  
**作用:** 设置GridView高度(在调用setAdapter()方法后调用此方法)。可用于解决GridView与ListView/RecyclerView等可滑动视图嵌套时只显示一行的问题。  
**整理自:** [利用反射获取GridView的高度](http://blog.csdn.net/jys1115/article/details/46045211)
