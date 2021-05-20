using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;

namespace Browser_Controls
{
    public partial class CefBrowser : UserControl
    {
        public CefBrowser()
        {
            InitializeComponent();
        }

        public CefBrowser(string startseite)
        {
            InitializeComponent();
            CefBrowserWindow.Address = startseite;
        }

        private void TbSuchleisteCef_OnKeyUp(object sender, KeyEventArgs e)
        {
            if (!string.IsNullOrWhiteSpace(tbSuchleisteCef.Text))
            {
                CefBrowserWindow.Address = tbSuchleisteCef.Text;
            }
        }

        private void BtSearchCef_OnClick(object sender, RoutedEventArgs e)
        {
            if (!string.IsNullOrWhiteSpace(tbSuchleisteCef.Text))
            {
                CefBrowserWindow.Address = tbSuchleisteCef.Text;
            }
        }
    }
}
