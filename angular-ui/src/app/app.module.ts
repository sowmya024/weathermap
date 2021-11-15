import { NgModule, APP_INITIALIZER } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './components/app.component';
import { ForecastComponent } from './components/forecast.component';
import { WeatherComponent } from './components/weather.component';

import { ConfigService } from './services/config.service';

@NgModule({
    declarations: [
        AppComponent,
        ForecastComponent,
        WeatherComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        AppRoutingModule
    ],
    providers: [
        {
            provide: APP_INITIALIZER,
            useFactory: (cs: ConfigService) => () => cs.load(),
            deps: [ConfigService],
            multi: true
        }
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
