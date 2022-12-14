import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import {Movie} from "./movie";
import {MoviesService} from "./movie.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public movies: Movie[];
  public editMovie: Movie;
  public deleteMovie: Movie;

  constructor(private movieService: MoviesService){}

  ngOnInit() {
    this.getMovies();
  }

  public getMovies(): void {
    this.movieService.getMovie().subscribe(
      (response: Movie[]) => {
        this.movies = response;
        console.log(this.movies);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddMovie(addForm: NgForm): void {
    document.getElementById('add-movie-form').click();
    this.movieService.addMovie(addForm.value).subscribe(
      (response: Movie) => {
        console.log(response);
        this.getMovies();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateMovie(movie: Movie): void {
    this.movieService.updateMovie(movie).subscribe(
      (response: Movie) => {
        console.log(response);
        this.getMovies();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteMovie(employeeId: number): void {
    this.movieService.deleteMovie(employeeId).subscribe(
      (response: void) => {
        console.log(response);
        this.getMovies();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchMovie(key: string): void {
    console.log(key);
    const results: Movie[] = [];
    for (const movie of this.movies) {
      if (movie.movie_name.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(movie);
      }
    }
    this.movies = results;
    if (results.length === 0 || !key) {
      this.getMovies();
    }
  }
  public onOpenController(movie: Movie, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'Controller');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addMovieController');
    }
    if (mode === 'edit') {
      this.editMovie = movie;
      button.setAttribute('data-target', '#updateMovieController');
    }
    if (mode === 'delete') {
      this.deleteMovie = movie;
      button.setAttribute('data-target', '#deleteMovieController');
    }
    container.appendChild(button);
    button.click();
  }
}
