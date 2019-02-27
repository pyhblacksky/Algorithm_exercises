package 剑指offer;

import java.util.Stack;

/**
 * @Author: pyh
 * @Date: 2019/2/17 21:24
 * @Version 1.0
 * @Function:
 *      定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 *      定义两个栈，一个放数据，一个放min数，当出现比当前数小的入栈，否则重复入栈最小栈的栈顶元素
 *
 *      思考：如何实现栈结构
 */
public class 包含min函数的栈 {

    Stack<Integer> data = new Stack<>();
    Stack<Integer> minData = new Stack<>();

    public void push(int node) {
        data.push(node);
        if(minData.isEmpty()){
            minData.push(node);
        } else {
            if(minData.peek() < node){
                minData.push(minData.peek());
            } else {
                minData.push(node);
            }
        }
    }

    public void pop() {
        data.pop();
        minData.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return minData.peek();
    }

}
