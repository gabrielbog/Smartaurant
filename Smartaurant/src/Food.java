public class Food
{
    //this class is used for storing useful information about the restaurant's food

    //members
    private int _id = 0;
    private String _name = null;
    private int _price = 0;
    private int _weight = 0;
    private int _calories = 0;
    private boolean _vegan = false;


    //constructors
    public Food(int _id, String _name, int _price, int _weight, int _calories, boolean _vegan)
    {
        //negative values will always be converted to positive ones

        this._id = _id;
        this._name = _name;
        if(_price < 0)
            _price = _price * -1;
        this._price = _price;
        if(_weight < 0)
            _weight = _weight * -1;
        this._weight = _weight;
        if(_calories < 0)
            _calories = _calories * -1;
        this._calories = _calories;
        this._vegan = _vegan;
    }


    //get, set, toString methods
    public int get_id()
    {
        return _id;
    }

    public void set_id(int _id)
    {
        this._id = _id;
    }

    public String get_name()
    {
        return _name;
    }

    public void set_name(String _name)
    {
        this._name = _name;
    }

    public int get_price()
    {
        return _price;
    }

    public void set_price(int _price)
    {
        if(_price < 0)
            _price = _price * -1;
        this._price = _price;
    }

    public int get_weight()
    {
        return _weight;
    }

    public void set_weight(int _weight)
    {
        if(_weight < 0)
            _weight = _weight * -1;
        this._weight = _weight;
    }

    public int get_calories()
    {
        return _calories;
    }

    public void set_calories(int _calories)
    {
        if(_calories < 0)
            _calories = _calories * -1;
        this._calories = _calories;
    }

    public boolean is_vegan()
    {
        return _vegan;
    }

    public void set_vegan(boolean _vegan)
    {
        this._vegan = _vegan;
    }

    @Override
    public String toString()
    {
        return "ID: =" + _id +
                ", Name ='" + _name +
                ", Price ='" + _price +
                "$" +
                ", Weight =" + _weight +
                "g" +
                ", Calories =" + _calories +
                "cal" +
                ", Vegan =" + _vegan;
    }
}
