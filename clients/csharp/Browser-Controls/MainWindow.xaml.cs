using System;
using System.Windows;

namespace Browser_Controls
{

    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void BtWpf_Click(object sender, RoutedEventArgs e)
        {
            Window wpfWindow = new Window();
            wpfWindow.MinHeight = 675;
            wpfWindow.MinWidth = 975;
            wpfWindow.Height = 675;
            wpfWindow.Width = 1315;
            wpfWindow.Title = "WPF interner Browser";
            wpfWindow.Content = new WpfBrowser();
            if (!String.IsNullOrWhiteSpace(tbStartUrl.Text))
            {
                wpfWindow.Content = new WpfBrowser(tbStartUrl.Text);
            }
            else
            {
                wpfWindow.Content = new WpfBrowser();
            }
            wpfWindow.Show();
        }

        private void BtCef_Click(object sender, RoutedEventArgs e)
        {
            Window cefWindow = new Window();
            cefWindow.MinHeight = 675;
            cefWindow.MinWidth = 975;
            cefWindow.Height = 675;
            cefWindow.Width = 1315;
            cefWindow.Title = "Chromium Browser";
            cefWindow.Content = new CefBrowser();
            if (!String.IsNullOrWhiteSpace(tbStartUrl.Text))
            {
                cefWindow.Content = new CefBrowser(tbStartUrl.Text);
            }
            else
            {
                cefWindow.Content = new CefBrowser();
            }

            cefWindow.Show();
        }

    }
}
