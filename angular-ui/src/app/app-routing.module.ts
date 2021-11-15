import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ForecastComponent } from './components/forecast.component';
import { WeatherComponent } from './components/weather.component';

const routes: Routes = [
    { path: 'forecast', component: ForecastComponent },
    { path: 'weather', component: WeatherComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
