package object

def student = new Student(name: "招摇", age: 24)
println("name:${student.name} age:${student.age}")
//默认已经实现get 和 set
println("name:${student.getName()} age:${student.getAge()}")
//对于类中没有的方法 编译器不会报错，这点和java不同
//但是运行的时候报groovy.lang.MissingMethodException: No signature of method: object.Student.foo88()
student.foo88()
//下面在student类中搞事情

//metaClass 动态的为一个类添加属性
Student.metaClass.score = 80
def student1 = new Student(name: "xiaoming", age: 18)
println(student1.score)
//metaClass 动态的为一个类添加方法
Student.metaClass.hellomethod = { str ->
    println("hellomethod ${str}")
}
def student2 = new Student()
student2.hellomethod("groovy")
//metaClass 动态的为一个类添加一个static静态方法
Student.metaClass.static.createStudent = {
    String name, Integer age -> new Student(name: name, age: age)
}
//我擦这都不智能提示
def student3 = Student.createStudent("namei", 19)
println(student3.name)
//如果要想在其它脚本中使用可以设置
//ExpandoMetaClass.enableGlobally()
