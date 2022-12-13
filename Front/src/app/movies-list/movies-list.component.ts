import {Component, OnInit} from '@angular/core';
import { Movies } from '../movies';
@Component({
  selector: 'app-movies-list',
  templateUrl: './movies-list.component.html',
  styleUrls: ['./movies-list.component.css']
})
export class MoviesListComponent implements OnInit{
  movies: moviesList[];

  contructor(){ }
  ngOnInit(): void {
  }
}
