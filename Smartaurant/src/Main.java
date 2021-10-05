public class Main
{
    public static void main(String[] args)
    {
        int _page = 0;
        Menu _menu = new Menu();

        while(_page != -1)
        {
            if(_page == 0)
            {
                _page = _menu.defaultPage();
            }
            else if(_page == 1)
            {
                _page = _menu.cataloguePage();
            }
            else if(_page == 2)
            {
                _page = _menu.contactPage();
            }
            else if(_page == 3)
            {
                _page = _menu.adminLogInPage();
            }
            else if(_page == 4)
            {
                _page = _menu.goodbyePage();
            }
            else if(_page == 5)
            {
                _page = _menu.addFoodPage();
            }
            else if(_page == 6)
            {
                _page = _menu.removeFoodPage();
            }
        }
    }
}
