public class polynomial {
        Eqnode Head;
        public void insert(double c, double p){
        Eqnode n= new Eqnode(c,p);
        if(Head==null){
            Head=n;
        }
        else{
                Eqnode temp=Head;
                while (temp.next!=null){
                        temp=temp.next;
                }
                if(temp==Head){
                        Head.next=n;
                        n.prev=Head;
                }
                else {
                        n.prev=temp;
                        temp.next=n;
                }


        }

        }
        public polynomial addition(polynomial p1, polynomial p2){
                Eqnode temp=p1.Head;
                Eqnode temp2=p2.Head;
                double coff;
                polynomial p3=new polynomial();
                while(temp!=null && temp2!=null){
                        if(temp.power==temp2.power){
                               coff= temp.coefficient+temp2.coefficient;
                               p3.insert(coff,temp.power);
                               temp=temp.next;
                               temp2=temp2.next;
                        }
                        else if(temp.power>temp2.power){
                                temp=temp.next;
                                p3.insert(temp.coefficient,temp.power);
                        }
                        else{
                                temp2=temp2.next;
                                p3.insert(temp2.coefficient, temp2.power);
                        }

                       // p3.display();
                }
                return p3;


        }
        public void display() {
                //String s="";
                Eqnode temp=Head;
                while (temp!=null){
                        System.out.print(temp.coefficient + "x^"+temp.power + "+"+" " );
                        temp=temp.next;
                }
        }
}
