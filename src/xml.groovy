import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.util.slurpersupport.GPathResult
import groovy.xml.MarkupBuilder

//xml 相关的练习
final String xml = '''
    <response version-api="2.0">
        <value>
            <books id="1" classification="android">
                <book available="20" id="1">
                    <title>疯狂Android讲义</title>
                    <author id="1">李刚</author>
                </book>
                <book available="14" id="2">
                   <title>第一行代码</title>
                   <author id="2">郭林</author>
               </book>
               <book available="13" id="3">
                   <title>Android开发艺术探索</title>
                   <author id="3">任玉刚</author>
               </book>
               <book available="5" id="4">
                   <title>Android源码设计模式</title>
                   <author id="4">何红辉</author>
               </book>
           </books>
           <books id="2" classification="web">
               <book available="10" id="1">
                   <title>Vue从入门到精通</title>
                   <author id="4">李刚</author>
               </book>
           </books>
       </value>
    </response>
'''
//解析xml
def slurper = new XmlSlurper()
//这个解析：疯狂Android讲义李刚第一行代码郭林Android开发艺术探索任玉刚Android源码设计模式何红辉Vue从入门到精通李刚
//把节点的值输出
def response = slurper.parseText(xml)
println(response)
println(response.value.books[0].book[0].title.text())
//访问当前标签的中的用@符号去引用
println response.value.books[1].book[0].@available
println response.value.books[1].book[0].@id

//找到作者是李刚的书进行筛选,先遍历books节点在遍历book节点
def ligangList = []
response.value.books.each {
    books ->
        books.book.each {
            book ->
                def author = book.author.text()
                if (author.equals("李刚")) {
                    ligangList.add(book.title.text())
                }
        }
}
println(ligangList)
// 深度遍历 实现上面相同的效果
def depth = response.depthFirst().findAll {
    book -> book.author.text() == '李刚'
}.collect {
    book ->
        book.title.text()
}
//广度遍历xml数据 这个可以根据选择边那块节点是不是
def nameres = response.value.books.children().findAll { node ->
    node.name() == 'book' && node.@id == '2'
}.collect { node ->
    return node.title.text()
}
println(depth)
println(nameres)

/**
 * 生成xml格式数据
 * <langs type='current' count='3' mainstream='true'>
 <language flavor='static' version='1.5'>Java</language>
 <language flavor='dynamic' version='1.6.0'>Groovy</language>
 <language flavor='dynamic' version='1.9'>JavaScript</language>
 </langs>
 */
def stringWriter = new StringWriter()
def builder = new MarkupBuilder(stringWriter)
//这种生成就跟对象那种形式差不多,值是直接写
builder.langs(type: 'current', count: '3', mainstream: 'true') {
    language(flavor: 'static', version: '1.5', value: "Java") {
        haha("manzi")
    }
}
println(stringWriter)

//另一种实现方式也是用上面方法只不过是用对象形式
//这里通过一个 json例子搞一下生成对象在生成xml

def student1 = new object.Student(name: "namei", age: 20)
def student2 = new object.Student(name: "lufei", age: 20)
def arrayList = [student1, student2]
//和Gson差不多
def toJson = JsonOutput.toJson(arrayList)
println(JsonOutput.prettyPrint(toJson))
def slur = new JsonSlurper()
//解析成对象
def object = slur.parseText(toJson)
def stuList = object as ArrayList
println(stuList)//[[age:20, name:namei], [age:20, name:lufei]]

def stringWriter1 = new StringWriter()
def builder1 = new MarkupBuilder(stringWriter1)

builder1.students() {
    stuList.each {
        stu ->
            //student(age:stu.age,name: stu.name)
            student() {
                age(stu.age)
                name(stu.name)
            }


    }
}
println(stringWriter1)
//<students>
//        <student>
//        <age>20</age>
//    <name>namei</name>
//        </student>
//  <student>
//    <age>20</age>
//<name>lufei</name>
//  </student>
//        </students>

