public class People {

private String name; //making a default method that can later create subclasses so that different people with different requests can be added

public People(String name){
    this.name = name;       //Gives people their own name
}

public String getName(){
return name;
}

public void giveRequest(Meters health, Meters money, Meters religion, Meters happy){ // A method that is used as a base for all request that will be Overriden in subclasses. This is so that each person can raise or lower the meters differently
    System.out.println("request");
    }
}

