final Class Person {
private final String name;
private final int age;
private final Address address;

public getAddress(){
        return new Address(a, b,c);
        }


public Person(String name, int age){
        ths.name =
        }


        }

final Class Address{s)

        -----------------------------------

        player - 2
        board - 100 * 100
        die - 1..6

        User:
        - userName
        - userPass

        Game:
        - List<Player> players;
        - List<Move> moves;
        + boardBuilder(typeOfBoard)

        + startGame()


        Player extends User:
        -

        Board:

        ClassicBoard:
        Cell[10][10]

        - addMove(newMovePoint, player)

        Cell:
        -

        Dice:
        + rollDice(): int

        Move:
        - startCell
        - endCell
        - player

        Properties:
        - startCell: Cell

        - endCell: Cell


        Ladder extends Properties:
        -

        Snake extends Properties:
        -






        --------------
class Parent
{
    int value = 1000;
    Parent()
    {  System.out.println("Parent Constructor");
    }

    public static void addPerson(){
        //
    }

}

class Child extends Parent
{
    int value = 10;
    Child()
    {
        System.out.println("Child Constructor");
    }
}

class Test
{
    public static void main(String[] args)
    {
        Child obj=new Child();
        System.out.println("Reference of Child Type :"
                + obj.value);  // Output? - 10


        Parent par = obj;


        System.out.println("Reference of Parent Type : "
                + par.value);  // Output? - 10
    }
}









    Given an array of integers, and a number ‘sum’, print all pairs in the array whose sum is equal to ‘sum’.

        Examples :
        Input  :  arr[] = {1, 5, 7, -1, 5},
        sum = 6
        Output : (1, 5) (7, -1) (1, 5)

        Input  :  arr[] = {2, 5, 17, -1},
        sum = 7
        Output :  (2, 5)

        -----------------------
        sum = 6
        for ele in arr:
        if ele exists in hashmap:
        count = hashmap.get(ele)
        hashmap.pt(ele, count+1)

        else:
        hashmap.put(ele, 1)
        Arrays.streams(arr).map(ele -> {
        key = sum - ele;

        })

        for ele in arr:
        key = sum - ele
        if hashmap.contains(key):
        coutn = hashmap.get(key)
        printNTimes(ele, key, count)












