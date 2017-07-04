router.controller('eventController', function($scope, $state, $cookies, $stateParams, EventsService, UserService){
$scope.tickets = [{id:1},{id:2},{id:3},{id:4},{id:5}];
    $scope.success = false;
    var id = $stateParams.id;
    $scope.numOfTickets = 0;
    console.log($stateParams.id);

        EventsService.getevent(id)
            .then(function(response){
                console.log(response);
                $scope.event = response.data;
                $scope.event.date_starting = new Date($scope.event.date_starting);
                $scope.event.date_ending = new Date($scope.event.date_ending);
            }, function (response){
                console.log(response);
            });


    $scope.book = function(id){

        var data = {};
        $scope.success = false;

        data.numOfTickets = $scope.numOfTickets.id;
        data.parent_id = $cookies.get('id');
        data.eventDate_id = id;
        console.log($cookies.get('signedIn'));
        if($cookies.get('signedIn') === 'yes' && $cookies.get('role') === 'parent')
            EventsService.book(data, $cookies.get('authToken'))
                .then(function(response){
                    console.log(response);
                    $scope.success = true;
                    EventsService.getevent(id)
                        .then(function(response){
                            console.log(response);
                            $scope.event = response.data;
                            $scope.event.date_starting = new Date($scope.event.date_starting);
                            $scope.event.date_ending = new Date($scope.event.date_ending);
                        }, function (response){
                            console.log(response);
                        });
                }, function(response){
                    console.log(response);
                });
    };

    $scope.changeSelectedItem = function(selected){
        $scope.numOfTickets = selected;
    }

    $scope.getProvider = function(id){
        $state.go('publicProfile', {id: id});
    }
});
