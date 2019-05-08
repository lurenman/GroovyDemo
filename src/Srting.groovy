//这种字符串是不可以变的
def name1 = '毛骗'
println(name1.class)
//这种字符串java那样后面可以改变的
def name2 = "lufei"
println(name2.class)
def name3 = """namei"""
println(name3.class)
//这种字符串可以输出格式，加\ 可以对齐
def name4 = """\
0ne
two
three
"""
println(name4)

def name5 = "suolong"
println(name5.class)
//这种必须双引号
def name6 = "It is: ${name5}"
println(name6)
//class org.codehaus.groovy.runtime.GStringImpl
println(name6.class)
//可扩展任意的表达式
def sum="this is sum:${8+2}"
println sum

def str="groovy hello"
println(str.center(8,"a"))
println(str.padLeft(8,"a"))
println(str.padRight(8,"a"))
def str1="hello"
println(str.compareTo(str1))
//groovy 可以直接这样比较
println(str>str1)
println(str.getAt(0))
//还可以当成数组搞
println(str[0])
println(str[0..3])
//去除掉str中包含的str1j
println(str.minus(str1))
println(str-str1)
//倒写
println(str.reverse())
//首字母大写
println(str.capitalize())
