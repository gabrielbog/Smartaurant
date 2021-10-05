import java.util.Arrays;
import java.util.Locale;
import java.util.Vector;

public class Restaurant
{
    //this class is used for the application's features

    //members
    private String _name = null;
    private int _total = 0;
    private Food _food[] = null;

    private boolean _isLoaded = false;
    private int _validFood = 0;

    private String _manager = "Mark Phillips";
    private String _contact = "555-1234";

    private String _adminUser = "John Doe";
    private String _adminPass = "thisisaverysecurepassword";
    private boolean _admin = false;


    //constructors
    public Restaurant(String _name, int _total)
    {
        this._name = _name;
        this._total = _total;
        _food = new Food[_total];
    }


    //get, set, toString methods
    public String get_name()
    {
        return _name;
    }

    public boolean set_name(String _name)
    {
        if(_admin == true)
        {
            this._name = _name;
            return true;
        }
        else
        {
            return false;
        }

    }

    public int get_total()
    {
        return _total;
    }

    public boolean set_total(int _total)
    {
        if(_admin == true)
        {
            this._total = _total;
            return true;
        }
        else
        {
            return false;
        }

    }

    public Food get_food(int i)
    {
        return _food[i];
    }

    public boolean set_food(Food[] _food, Food _newFood, int i)
    {
        if(_admin == true)
        {
            _food[i] = _newFood;
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean is_isLoaded()
    {
        return _isLoaded;
    }

    public void set_isLoaded(boolean _isLoaded)
    {
        this._isLoaded = _isLoaded;
    }

    public String get_manager()
    {
        return _manager;
    }

    public boolean set_manager(String _manager)
    {
        if(_admin == true)
        {
            this._manager = _manager;
            return true;
        }
        else
        {
            return false;
        }
    }

    public String get_contact()
    {
        return _contact;
    }

    public boolean set_contact(String _contact)
    {
        if(_admin == true)
        {
            this._contact = _contact;
            return true;
        }
        else
        {
            return false;
        }
    }

    public String get_adminUser()
    {
        if(_admin == true)
        {
            return _adminUser;
        }
        else
        {
            return "ACCESS DENIED";
        }
    }

    public boolean set_adminUser(String _adminUser)
    {
        if(_admin == true)
        {
            this._adminUser = _adminUser;
            return true;
        }
        else
        {
            return false;
        }
    }

    public String get_adminPass()
    {
        if(_admin == true)
        {
            return _adminPass;
        }
        else
        {
            return "ACCESS DENIED";
        }
    }

    public boolean set_adminPass(String _adminPass)
    {
        if(_admin == true)
        {
            this._adminPass = _adminPass;
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean is_admin()
    {
        return _admin;
    }

    public boolean set_admin(boolean _admin)
    {
        if(this._admin == true)
        {
            this._admin = _admin;
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString()
    {
        if(_admin == false)
        {
            return "Restaurant Name = " + _name +
                    ", Total Food Types = " + _total +
                    //afisare lista mancare la apelare toString
                    //", _food=" + Arrays.toString(_food) +
                    ", Manager = " + _manager +
                    ", Phone Number Contact = " + _contact;
        }
        else
        {
            return "Restaurant Name = " + _name +
                    ", Total Food Types = " + _total +
                    //afisare lista mancare la apelare toString
                    //", _food=" + Arrays.toString(_food) +
                    ", Manager = " + _manager +
                    ", Phone Number Contact = " + _contact +
                    ", Admin Rights = " + _admin +
                    ", Admin User = " + _adminUser +
                    ", Admin Password = " + _adminPass;
        }

    }


    //other methods
    public Food[] get_foodVector()
    {
        return _food;
    }

    public boolean set_foodVector(Food[] _food)
    {
        if(_admin == true)
        {
            this._food = _food;
            return true;
        }
        else
        {
            return false;
        }
    }

    public void adminLogIn(String _adminUser, String _adminPass)
    {
        if(_adminUser.equals(this._adminUser) && _adminPass.equals((this._adminPass)))
        {
            _admin = true;
        }
    }

    public void loadFood()
    {
        if(_isLoaded == false)
        {
            _isLoaded = true;

            _validFood = getLatestFood();

            _food[_validFood] = new Food(_validFood, "Burger", 5, 100, 300, false);
            ++_validFood;
            _food[_validFood] = new Food(_validFood, "Vegan Burger", 8, 100, 200, true);
            ++_validFood;
            _food[_validFood] = new Food(_validFood, "Caesar Salad", 3, 50, 50, true);
            ++_validFood;
            _food[_validFood] = new Food(_validFood, "Pizza Quattro Formaggi", 20, 1000, 5000, false);
            ++_validFood;
            _food[_validFood] = new Food(_validFood, "Spaghetti Carbonara", 15, 300, 500, false);
            ++_validFood;
            _food[_validFood] = new Food(_validFood, "Impossible Wrapper", 10, 200, 600, false);
            ++_validFood;
            _food[_validFood] = new Food(_validFood, "Vegan Chili", 5, 100, 300, true);
            ++_validFood;
        }
    }

    public int getLatestFood()
    {
        _validFood = 0;
        while(_food[_validFood] != null)
            ++_validFood;
        return _validFood;
    }

    public void showMenuList()
    {
        for(int i = 0; i < _food.length; ++i)
        {
            if(_food[i] != null)
                System.out.println(_food[i].toString());
        }
    }

    public void removeFood(Food[] _food, int i)
    {
        for(int j = i; j < getLatestFood(); ++j)
        {
            _food[j] = _food[j + 1];
            if(_food[j] != null)
                _food[j].set_id(_food[j].get_id() - 1);
        }
    }
}
