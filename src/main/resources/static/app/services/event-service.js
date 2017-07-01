router.factory('EventsService', function($http) {
    var eventsService = {};

    eventsService.submitEvent = function(request, authToken){
        return $http.post('/api/submitEvent/',request,{headers: {'authToken': authToken}})
            .then(function(response){
                return response;
            });
    };

    var eventService = {};

    eventService.search = function (query) {
        return $http.post('/api/searchEvent', {text: query})
            .then(function (response) {
                console.log(response);
                return response;
            });

    };


    return eventService;
});