router.factory('EventsService', function($http) {
    var eventsService = {};

    eventsService.submitEvent = function(request, authToken){
        return $http.post('/api/submitEvent/',request,{headers: {'authToken': authToken}})
            .then(function(response){
                return response;
            });
    };

    return eventsService;
});