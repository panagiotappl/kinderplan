router.factory('EventsService', function($http) {
    var eventsService = {};

    eventsService.submitEvent = function(request){
        return $http.post('/api/submitEvent/',request)
            .then(function(response){
                return response;
            });
    };

    return eventsService;
});