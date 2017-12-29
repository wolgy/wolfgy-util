# wolfgy-util
Util collection of mine.我的个人工具类集合。

## Android相关工具类
#### [ResourceUtil/R文件相关工具类](https://github.com/wolgy/wolfgy-util/blob/master/src/main/java/com/wolfgy/util/android/ResourceUtil.java)
1. getResourceFieldName(Class<?> r , String resourceType , int value)  
作用：获取R文件中资源值对应的字段名。  
示例：`drawable`文件夹下名为`ic_catelog_0006010`的资源文件，
在`R`文件中生成的资源字段为`public static final int ic_catelog_0006010=0x7f070061`。
调用本方法传入`resourceType="drawable"`,`value=0x7f070061`,方法返回`"ic_catelog_0006010"`。
2. getResourceFieldValue(Class<?> r , String resourceType , String name)  
作用：获取R文件中资源字段名对应的值。  
示例：`drawable`文件夹下名为`ic_catelog_0006010`的资源文件，
在`R`文件中生成的资源字段为`public static final int ic_catelog_0006010=0x7f070061`。
调用本方法传入`resourceType="drawable"`,`name="ic_catelog_0006010"`,方法返回`0x7f070061`。
####  [GridViewUtil/GridView相关工具类](https://github.com/wolgy/wolfgy-util/blob/master/src/main/java/com/wolfgy/util/android/GridViewUtil.java)
1. setGridViewHeightBasedOnChildren(GridView gridView)  
作用：设置GridView高度(在调用setAdapter()方法后调用此方法)。可用于解决GridView与ListView/RecyclerView等可滑动视图嵌套时只显示一行的问题。  
整理自:[利用反射获取GridView的高度](http://blog.csdn.net/jys1115/article/details/46045211)
