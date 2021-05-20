using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;

namespace Browser_Controls
{
    public partial class WpfBrowser : UserControl
    {
        ProgressBar progressBar = new ProgressBar();

        public WpfBrowser()
        {
            InitializeComponent();
            Uri startseite = new Uri("https://www.google.de/");
            wpfWebBrowser.Source = startseite;
        }

        public WpfBrowser(string startseite)
        {
            InitializeComponent();
            //Falls der User in der Startmaske schon eine URL eingegeben hat, soll geprüft werden ob sie mit http beginnt,
            //da der WPF interne Browser nur URLs lesen kann, die mit http:// oder https:// beginnen
            if (!string.IsNullOrWhiteSpace(startseite))
            {
                if (!startseite.StartsWith("http"))
                {
                    Uri newUri = new Uri($"http://{startseite}");
                    wpfWebBrowser.Source = newUri;
                    tbSuchleiste.Text = newUri.ToString();
                }
                else
                {
                    Uri startUri = new Uri(startseite);
                    wpfWebBrowser.Source = startUri;
                    tbSuchleiste.Text = startUri.ToString();
                }
            }


        }

        private void BtSearchWPF_Click(object sender, RoutedEventArgs e)
        {
            if (!String.IsNullOrWhiteSpace(tbSuchleiste.Text))
            {
                Uri uri = new Uri($"{tbSuchleiste.Text}", UriKind.RelativeOrAbsolute);

                if (!uri.IsAbsoluteUri)
                {
                    MessageBox.Show("Bitte vollständige URL eingeben.\nBeispiel: 'www.google.de'");
                    return;
                }

                wpfWebBrowser.Navigate(uri);
            }
        }

        private void BtBackWPF_OnClick(object sender, RoutedEventArgs e)
        {
            if (wpfWebBrowser.CanGoBack) wpfWebBrowser.GoBack();
        }

        private void BtForwardWPF_OnClick(object sender, RoutedEventArgs e)
        {
            if (wpfWebBrowser.CanGoForward) wpfWebBrowser.GoForward();
        }

        private void TbSuchleiste_OnKeyUp(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Enter)
            {
                if (!String.IsNullOrWhiteSpace(tbSuchleiste.Text))
                {
                    Uri uri = new Uri($"http://{tbSuchleiste.Text}", UriKind.RelativeOrAbsolute);

                    if (!uri.IsAbsoluteUri)
                    {
                        MessageBox.Show("Bitte vollständige URL eingeben.\nBeispiel: 'www.google.de'");
                        return;
                    }

                    wpfWebBrowser.Navigate(uri);
                }
            }
        }
        private void BtRefreshWPF_OnClick(object sender, RoutedEventArgs e)
        {
            if (wpfWebBrowser.IsEnabled) wpfWebBrowser.Refresh();
        }

    }
}
