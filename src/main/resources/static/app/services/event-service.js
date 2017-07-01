
router.factory('EventService', function($http) {
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