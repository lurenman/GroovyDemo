//闭包进阶
def scriptClouser = {
    //代表闭包定义处的类
    println("this:" + this)
    //代表闭包定义处的类或对象
    println("owner:" + owner)
    //代表任意对象，默认与owner一致
    println("delegate:" + delegate)
}
//scriptClouser.call()
//在闭包中声明
def nestClouser = {
    def innerClouser = {
        println("nnerClouser this:" + this)
        println("nnerClouser owner:" + owner)
        println("nnerClouser delegate:" + delegate)
    }
    //delegate是可以随便修改的，this，owner是不可以修改的
    innerClouser.delegate = this
    innerClouser.call()
}
nestClouser.call()

class Student {
    String name
    def clouser = {
        println("this is ${name}")
    }
}

class Teacher {
    String name
}

def student = new Student(name:"lufei")

def teacher = new Teacher(name:"namei")


student.clouser.delegate=teacher
//指定闭包策略 如果指定DELEGATE_FIRST 如果teacher中没有name属性就在student中找
//如果指定DELEGATE_ONLY 如果teacher中没有就会报错，很容易理解
student.clouser.resolveStrategy=groovy.lang.Closure.DELEGATE_FIRST
student.clouser.call()