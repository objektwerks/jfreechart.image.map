JFreeChart Image Map
--------------------
>JfreeChart image map app using ScalaFx and Scala 3.

Note
----
>While a chart is persistable to a file; the generated image map is effectively empty!

>The file generated is:
```
./target/styles-chart.png
```

>The image map generated is:
```
<map id="imageMap" name="imageMap"></map>
```
>The JFreeChart API is a bit notorious for its complexity. ;)

Build
-----
sbt clean compile

Run
---
sbt run

Resources
---------
* [JFreeChart](https://www.jfree.org/jfreechart/)
* [JFreeChart ExportUtils](https://javadoc.io/doc/org.jfree/jfreechart/latest/org/jfree/chart/util/ExportUtils.html)
* [JFreeChart ImageMapUtils](https://javadoc.io/doc/org.jfree/jfreechart/latest/org/jfree/chart/imagemap/ImageMapUtils.html)
* [Image Map](https://www.w3schools.com/html/html_images_imagemap.asp)