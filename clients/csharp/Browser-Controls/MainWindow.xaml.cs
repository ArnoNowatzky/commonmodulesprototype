using System;
using System.Windows;
using System.Collections.Generic;
using System.Diagnostics;
using System.Collections.Generic;
using System.Diagnostics;
using De.Noventi.Cm.Client.Csharp.Runtime.Api;
using De.Noventi.Cm.Client.Csharp.Runtime.Client;
using De.Noventi.Cm.Client.Csharp.Runtime.Model;
using De.Noventi.Cm.Client.Csharp.Service.Api;
using De.Noventi.Cm.Client.Csharp.Service.Model;
using De.Noventi.Cm.Client.Csharp.Service.Client;

namespace Browser_Controls
{

    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private SetupModulesParamDTO createAdminParam (string type)
        {
            SetupModulesParamDTO setupModules = new SetupModulesParamDTO();
            setupModules.Path = "../../../../build/example";

            string installationDescriptor = System.IO.File.ReadAllText("../../../../../install_jar.xml", System.Text.Encoding.Default);
            setupModules.Descriptor = installationDescriptor;
            return setupModules;
        }

        private void BtAdminInstall_Click (object sender, RoutedEventArgs e)
        {
            Debug.Print("Install clicked");
            ModuleApi apiInstance = new ModuleApi();
            Debug.Print($"Url {apiInstance.GetBasePath()}");
            apiInstance.InstallModules(createAdminParam(""));
        }

        private void BtAdminStart_Click(object sender, RoutedEventArgs e)
        {
            Debug.Print("Start clicked");
            ModuleApi apiInstance = new ModuleApi();
            apiInstance.StartModules(createAdminParam(""));

        }

        private void BtAdminStop_Click(object sender, RoutedEventArgs e)
        {
            Debug.Print("Stop clicked");
            ModuleApi apiInstance = new ModuleApi();
            apiInstance.StopModules(createAdminParam(""));

        }
        private void BtServiceSynch_Click(object sender, RoutedEventArgs e)
        {
            var apiInstance = new CustomerApi();

            try
            {
                CustomerDTO customer = apiInstance.GetCustomer("1");
                txtId.Text = customer.Id;
                txtName.Text = customer.Name;
                txtFirstName.Text = customer.Firstname;
            }
            catch (Exception exception)
            {
                Debug.Print("Exception when calling ModuleApi.InstallModules: " + exception.Message);
                Debug.Print(exception.StackTrace);

                MessageBox.Show("Synch service: " + exception.Message, "Error", MessageBoxButton.OK);
                txtId.Text = "";
                txtName.Text = "";
                txtFirstName.Text = "";
            }

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
