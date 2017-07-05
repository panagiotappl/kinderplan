router.controller('eventController', function($scope, $state, $cookies, $stateParams, EventsService, UserService){
    $scope.success = false;
    $scope.notAuthed = false;
    $scope.notLeft = false;
    $scope.notEnough = false;
    $scope.noPoints = false;
$scope.error = true;
    var id = $stateParams.id;
    var event_id = $stateParams.id;
    $scope.numOfTickets = 0;

    EventsService.getevent(id)
        .then(function(response){
            console.log(response);
            $scope.event = response.data;
            // angular.forEach($scope.event.photos, function(value, key) {
            //     this.push({
            //         'name': 'Name',
            //         'url': value.path
            //     });
            // }, photos);

            //$scope.event.slidephotos = photos;

            $scope.event.date_starting = new Date($scope.event.date_starting);
            $scope.event.date_ending = new Date($scope.event.date_ending);
            for(var i = 0; i < $scope.event.dates.length; i++){
                $scope.event.dates[i].list = [];
                for(var j = 1; j <= $scope.event.dates[i].available_tickets; j++){
                    $scope.event.dates[i].list.push({id: j});
                }
            }
            console.log($scope.event);
        }, function (response){
            console.log(response);
        });



    $scope.book = function(id, available){

        var data = {};
        $scope.success = false;
        data.eventDate_id = id;
        data.numOfTickets = $scope.numOfTickets.id;
        data.parent_id = $cookies.get('id');
        if(data.numOfTickets > available )
            $scope.notEnough = true;
        if($cookies.get('signedIn') === 'yes' && $cookies.get('role') === 'parent') {
            EventsService.book(data, $cookies.get('authToken'))
                .then(function (response) {
                    $scope.success = true;

                }, function (response) {
                    console.log(response);
                    console.log(response.data.message);
                    $scope.message = response.data.message;

                    $scope.error = true;
                });
        }else{
            $scope.notAuthed = true;
        }
    };

    $scope.changeSelectedItem = function(selected){
        $scope.numOfTickets = selected;
    };

    $scope.getProvider = function(id){
        $state.go('publicProfile', {id: id});
    };
});
