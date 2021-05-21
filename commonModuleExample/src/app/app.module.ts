import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';


import {environment} from '../environments/environment';
import {HttpClientModule} from '@angular/common/http';
import {MatOptionModule} from '@angular/material/core';
import {MatSelectModule} from '@angular/material/select';
import {BASE_PATH as BASE_PATH_CM} from './generatedCm';
import {BASE_PATH as BASE_PATH_WAWI} from './generatedWawi';



@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    MatGridListModule,
    MatTableModule,
    MatInputModule,
    MatOptionModule,
    MatSelectModule,

    HttpClientModule
  ],
  providers: [{
      provide: BASE_PATH_CM,
      useValue: environment.API_BASE_PATH_CM
    }, {
      provide: BASE_PATH_WAWI,
      useValue: environment.API_BASE_PATH_WAWI
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
