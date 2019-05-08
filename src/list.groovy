def ary = new ArrayList<>()
println(ary.class)
//groovy 定义默认是ArrayList
def ary1 = [1, 2, 3, 4, "haha"]
println(ary1.class)
println(ary1.size())
//如果要定义数组
def ary3 = [1, 2, 3] as int[]
println(ary3.class)
//如果要定义数组
int[] ary4 = [1, 2, 3]
println(ary4.class)

def sortlist = [10, 4, 5, 89, 32, -5, 6, 18]
//从小到大排序
//Collections.sort(sortlist)

Comparator mc = {
    a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1
}
//Collections.sort(sortlist,mc)
sortlist.sort()
println(sortlist)
sortlist.sort {
    a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1
}
println(sortlist)

def strlist = ["abc", "a", "hello", "dsdsdssd", "bb"]
strlist.sort {
    it.size()
}
println(strlist)

def findList = [1, 2, 3, 4, 5, 6, 7, 8]
def find = findList.find {
    return it % 2 == 0
}
println(find)
def findAll = findList.findAll {
    return it % 2 == 0
}
println(findAll)
//any 略
//取最小值
def min = findList.min {
    return it
}
println(min)
//取最大值
def max = findList.max {
    return it
}
println(max)

def count = findList.count {
    it % 2 == 0
}
println(count)