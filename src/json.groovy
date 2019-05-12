import groovy.json.JsonOutput
import groovy.json.JsonSlurper

//json 的操作

def student1 = new object.Student(name:"namei",age: 20)
def student2 = new object.Student(name:"lufei",age: 20)
def arrayList=[student1,student2]
//和Gson差不多
def toJson = JsonOutput.toJson(arrayList)
println(toJson)
println(JsonOutput.prettyPrint(toJson))
//将json转化为对象
def slurper = new JsonSlurper()
def object = slurper.parseText(toJson)
println(object.toString())

