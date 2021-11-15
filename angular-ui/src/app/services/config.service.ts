import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class ConfigService {

    config: any;

    constructor(private http: HttpClient) { }

    get(key: string) {
        return this.config[key];
    }

    apiUrl(path: string) {
        return this.config['apiBaseUrl'] + '/' + path;
    }

    load() {
        return this.http.get('./assets/config.json').subscribe((config: any) => this.config = config);
    }
}
