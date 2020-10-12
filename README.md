# Movie
Movie is a service that is responsible for movies manipulation. Movie entity represents movie in catalog

Functions:
* createMovie(Movie movie) – adds new movie
* removeMovie(Movie movie) – removes movie
* getMovie() – shows all movies
* getMovie(id) – shows concreate movie by id
* getMovie(name) – finds movie by name(in all)


# Order
Oder is a service that is responsible for create order(basket) for a given user. Order entity represents order with set of movies.

Functions:
* getOrder(id) – gets concreate order
* getOrder(list) – gets all orders
* createOrder(Order) – create order(for new user)
* createOrder(pay/id) – pays for movie


# Recommendation
Recommendation is a service that is responsible to get movies sorted by raiting. 

Functions:
* getRecommendation() – Gets recommendation movies



# Wishlist
Wishlist is a service that is responsible for create wishes for a given user. Wish entity represents wishes with users.

Functions:
* getWishes(id) – gets wishes by concreate user
* getWishlist(list) – gets all wishes in database
* addWish(userId/WishId) – adds wish for a user
* deleteWish(userId/WishId) – removes wish for a user
* createWish(id) – creates wish for user



#Front:
https://github.com/Alikhan247/Movie-front
