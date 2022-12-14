import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from './movie';
import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class MoviesService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public getMovie(): Observable<Movie[]> {
    return this.http.get<Movie[]>(`${this.apiServerUrl}/movies/find/{id}`);
  }

  public addMovie(movie: Movie): Observable<Movie> {
    return this.http.post<Movie>(`${this.apiServerUrl}/movies/create`, movie);
  }

  public updateMovie(movie: Movie): Observable<Movie> {
    return this.http.put<Movie>(`${this.apiServerUrl}/movies/update/{id}`, movie);
  }

  public deleteMovie(movieID: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/movies/delete/${movieID}`);
  }
}
