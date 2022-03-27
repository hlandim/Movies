# Movies

Architecture used: MVVM + Dependencie Injenction + Jectpeack Compose.

- Communications between View <-> ViewModel are made using Android Jetpack Compose and LiveData. 
- Using [Retrofit](https://square.github.io/retrofit/) library to comunicate with [themoviedb](https://developers.themoviedb.org/3/movies) API.
- Using [Mockito](https://github.com/mockito/mockito) library to create integration tests.
- Using [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for Dependencies injection.
- Using [Jectpack Compose](https://developer.android.com/jetpack/compose/) to create layout and automated test.
- Handling network connection lost.
- Using courotines for assyncronous work.
- Light and Dark mode styles.


### To do
- Use Jetpack [Paging](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) library to implement the pagination.


### Images

| List | Details  |
|---|---|
| <img src="https://github.com/hlandim/Movies/blob/main/readme/list.png" width="300"/>    |  <img src="https://github.com/hlandim/Movies/blob/main/readme/details.png" width="300"/> |
