import java.util.Scanner;
import java.lang.Thread;

public class Menu
{
    //this class is used for handling the "user interface"

    //members
    private int _page = 0;
    private Restaurant _restaurant = new Restaurant("Kurger Bing", 256);

    private int _validFood = 0;
    private Food _food = null;

    public String _name = null;
    public int _price = 0;
    public int _weight = 0;
    public int _calories = 0;
    public boolean _vegan = false;

    public Scanner _scan = new Scanner(System.in);
    public int _selection = 0;

    public int _cardCode = 0;

    public String _adminUser = null;
    public String _adminPass = null;

    //constructors
    public Menu()
    {
        _page = 0;
    }

    //get, set, toString()


    public int get_page()
    {
        return _page;
    }

    public void set_page(int _page)
    {
        this._page = _page;
    }

    public Restaurant get_restaurant()
    {
        return _restaurant;
    }

    public void set_restaurant(Restaurant _restaurant)
    {
        this._restaurant = _restaurant;
    }

    public int get_validFood()
    {
        return _validFood;
    }

    public void set_validFood(int _validFood)
    {
        this._validFood = _validFood;
    }

    public Food get_food()
    {
        return _food;
    }

    public void set_food(Food _food)
    {
        this._food = _food;
    }

    @Override
    public String toString()
    {
        return "Menu{" +
                "_page=" + _page +
                ", _restaurant=" + _restaurant +
                ", _validFood=" + _validFood +
                ", _food=" + _food +
                ", _name='" + _name + '\'' +
                ", _price=" + _price +
                ", _weight=" + _weight +
                ", _calories=" + _calories +
                ", _vegan=" + _vegan +
                ", _scan=" + _scan +
                ", _selection=" + _selection +
                ", _cardCode=" + _cardCode +
                ", _adminUser='" + _adminUser + '\'' +
                ", _adminPass='" + _adminPass + '\'' +
                '}';
    }

    //methods
    public int invalidPage(int _page)
    {
        System.out.flush();
        System.out.println("Invalid selection! Please try again.");

        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {
            System.out.println("got interrupted!");
        }

        return _page;
    }

    public int defaultPage()
    {
        _restaurant.loadFood();
        System.out.println("Welcome to " + _restaurant.get_name() + "! How may we serve you today?");
        System.out.println("1. Check the Food catalogue");
        System.out.println("2. Check the contact details");
        System.out.println("3. Log in the database - FOR ADMINISTRATORS ONLY!");
        System.out.println("4. Leave the store");

        if(_restaurant.is_admin() == true)
        {
            System.out.println();
            System.out.println("5. Add new food items");
            System.out.println("6. Remove food items");
        }
        System.out.print("Choose an option: ");

        _selection = _scan.nextInt();
        if(_selection >= 1 && _selection <= 4)
            return _selection;
        else if(_selection >= 5 && _selection <= 6)
        {
            if(_restaurant.is_admin() == false)
                return invalidPage(0);
            else
                return _selection;
        }
        else
            return invalidPage(0);
    }

    public int contactPage()
    {
        //contact detail page
        System.out.println("Manager: " + _restaurant.get_manager());
        System.out.println("Phone Number: " + _restaurant.get_contact());
        System.out.println("Press any key to return to the main menu.");
        _selection = _scan.nextInt();
        return 0;
    }

    public int purchasePage()
    {
        System.out.print("Introduce card code: ");
        _cardCode = _scan.nextInt();
        if(_cardCode < 0)
        {
            System.out.println("This is not a valid card code!!!");

            try
            {
                Thread.sleep(5000);
            }
            catch(InterruptedException e)
            {
                System.out.println("got interrupted!");
            }
            return 0;
        }
        _cardCode = 0;
        return 4;
    }

    public int cataloguePage()
    {
        System.out.println("Take a look at our catalogue.");
        _restaurant.loadFood();
        _restaurant.showMenuList();

        System.out.println();
        System.out.print("Select food item: ");
        _selection = _scan.nextInt();
        if(_restaurant.get_food(_selection) != null)
        {
            return purchasePage();
        }
        else
        {
            return invalidPage(0);
        }
    }

    public int adminLogInPage()
    {
        System.out.flush();
        if(_restaurant.is_admin() == false)
        {
            _scan.nextLine();
            System.out.println("Introduce the following details:");
            System.out.print("Username: ");
            _adminUser = _scan.nextLine();
            System.out.print("Password: ");
            _adminPass = _scan.nextLine();

            _restaurant.adminLogIn(_adminUser, _adminPass);
            if(_restaurant.is_admin() == true)
            {
                System.out.flush();
                System.out.println("Log in successful. Welcome, " + _adminUser);

                try
                {
                    Thread.sleep(5000);
                }
                catch(InterruptedException ex)
                {
                    System.out.println("got interrupted!");
                }
            }
            else
            {
                System.out.flush();
                System.out.println("ACCESS DENIED!");

                try
                {
                    Thread.sleep(5000);
                }
                catch(InterruptedException e)
                {
                    System.out.println("got interrupted!");
                }
            }
        }
        return 0;
    }

    public int addFoodPage()
    {
        _scan.nextLine();
        _validFood = _restaurant.getLatestFood();

        System.out.print("Introduce Food Name: ");
        _name = _scan.nextLine();
        System.out.print("Introduce Food Price: ");
        _price = _scan.nextInt();
        System.out.print("Introduce Food Weight: ");
        _weight = _scan.nextInt();
        System.out.print("Introduce Food Calories: ");
        _calories = _scan.nextInt();
        System.out.print("Is the new food vegan? 0 - no, otherwise - yes: ");
        _selection = _scan.nextInt();
        if(_selection == 0)
            _vegan = false;
        else
            _vegan = true;

        _food = new Food(_validFood, _name, _price, _weight, _calories, _vegan);
        _restaurant.set_food(_restaurant.get_foodVector(), _food, _validFood);
        System.out.println("Food added!");

        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {
            System.out.println("got interrupted!");
        }
        return 0;
    }

    public int removeFoodPage()
    {
        System.out.println("Take a look at our catalogue.");
        _restaurant.loadFood();
        _restaurant.showMenuList();

        System.out.println();
        System.out.print("Choose the ID of the food you would like to be removed: ");
        _selection = _scan.nextInt();
        if(_restaurant.get_food(_selection) != null)
        {
            _restaurant.removeFood(_restaurant.get_foodVector(), _selection);
            System.out.println("Food has been removed!");

            try
            {
                Thread.sleep(5000);
            }
            catch(InterruptedException e)
            {
                System.out.println("got interrupted!");
            }
            return 0;
        }
        else
        {
            return invalidPage(0);
        }
    }

    public int goodbyePage()
    {
        System.out.flush();
        System.out.println("Thank you for visiting us and enjoy the food!");
        return -1;
    }
}
