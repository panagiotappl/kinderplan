
router.factory('EventsService', function($http) {
    var eventsService = {};

    eventsService.submitEvent = function(request, authToken){
        console.log(request);
        return $http.post('/api/submitEvent/',request,{headers: {'authToken': authToken}})
            .then(function(response){
                return response;
            });
    };

    eventsService.search = function (data) {
        return $http.post('/api/searchEvent', data)
            .then(function (response) {
                console.log(response);
                return response;
            });

    };

    eventsService.getevent = function(id){
        return $http.get('/api/event/' + id)
            .then(function(response) {
                console.log(response);
                return response;
            });

    };

    eventsService.book = function(data, authToken){
        console.log(authToken);
        console.log(data);
        return $http.post('/api/event/book', data, {headers: {'authToken': authToken}})
            .then(function(response){
                console.log(response);
                return response;
            });
    };


    eventsService.advanced = function(request){
        return $http.post('/api/searchEvent', request)
            .then(function(response){
                return response;
            })
    }

    return eventsService;
});