
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ConfigService } from '../services/config.service';

@Component({
    selector: 'app-root',
    templateUrl: './weather.component.html',
    styleUrls: ['./app.component.css']
})
export class WeatherComponent implements OnInit {

    city: string = "";

    data: any = {};

    constructor(private http: HttpClient, private conf: ConfigService) { }

    ngOnInit(): void {
    }

    loadData(): void {
        if (this.city.length == 0) {
            alert('Invalid city/state');
            return;
        }
        let url = this.conf.apiUrl("weather?location=" + encodeURIComponent(this.city));
        this.http.get(url).subscribe((res: any) => this.data = res);
    }

}
