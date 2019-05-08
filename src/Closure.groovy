//闭包练习

def closuer = {
    println("hello clouser!")
}
//调用闭包
closuer.call()
//closuer()
//带参数的传值-> es6 是=>这个
def clouser1 = {
    String name -> println("hello ${name}")
}
clouser1.call("namei")
//闭包里面定义的类型就不能def了
def clouser2 = {
    String name, Integer age -> println("hello ${name} age:${age}")
}
clouser2.call("lufei", 18)
//闭包有个默认的参数
def clouser3 = { println("hello ${it}") }
clouser3.call("xiaoming")
//
def clouser4 = {
    String name ->
        return "hello ${name}"
}
def result = clouser4.call("招摇")
println(result)
//闭包是一定有返回值的 ，像这种没有定义return就是返回null代替(注意一下就ok)
def clouser5 = {
    String name ->name
}
println(clouser5.call())
//对于闭包传什么还是要点进去看一下
int fab(int number) {
    int result = 1
    1.upto(number, { num -> result *= num })
    return result
}

def x = fab(5)
println(x)

int fab1(int number) {
    int result = 1
    number.downto(1) { num -> result *= num }
    return result
}

println(fab1(5))

def str="hello groovy"
//字符串遍历
str.each {
    s->print(s)
}
println()
//每个字符输出两次
str.each{
    s->print(s.multiply(2))
}
println()
def str1="this is 3 and 5"
//这个find只是找到第一个
def find = str1.find {
    String s -> s.isNumber()
}
println(find)
def findall=str1.findAll{
    String s->s.isNumber()
}
//findall.toListString()
println(findall)
//判断有没有数字，返回boolean值
def any = str1.any {
    String s -> s.isNumber()
}
println(any)
//每项都符合条件返回true
def every = str1.every {
    String s -> s.isNumber()
}
println(every)

def collect = str1.collect {
    it.toUpperCase()
}
println(collect)
