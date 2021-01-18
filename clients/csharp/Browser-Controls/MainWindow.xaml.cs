using System;
using System.Windows;
using System.Collections.Generic;
using System.Diagnostics;
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.De.Noventi.Cm.Client.Csharp.Service.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.De.Noventi.Cm.Client.Csharp.Service.Model;

namespace Browser_Controls
{

    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void BtServiceSynch_Click(object sender, RoutedEventArgs e)
        {
            var apiInstance = new CustomerApi();

            try
            {
                apiInstance.GetCustomer("1");
            }
            catch (ApiException exception)
            {
                Debug.Print("Exception when calling ModuleApi.InstallModules: " + exception.Message);
                Debug.Print("Status Code: " + exception.ErrorCode);
                Debug.Print(exception.StackTrace);
            }

            txtId.Text = "1";
            txtName.Text = "Name";
            txtFirstName.Text = "First name";
            System.Diagnostics.Debug.WriteLine("Hello from Service");

        }


        private void BtWpf_Click(object sender, RoutedEventArgs e)
        {
            System.Diagnostics.Debug.WriteLine("Hello from BtWpf");

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
