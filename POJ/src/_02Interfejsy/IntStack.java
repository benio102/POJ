package _02Interfejsy;

// definicja interfejsu stosow liczb calkowitych
interface IntStack {
    void push(int item); // element na stos
    int pop();           // zdejmij element ze stosu
}
// st.push(x);
// st.pop() == x