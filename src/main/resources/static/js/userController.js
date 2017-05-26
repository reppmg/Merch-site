module
    .controller('userController', function ($scope, $http) {

        $http.get('/user').then(function (data) {
            var photo_id;
            $scope.user_id = data.data.uid;

            $scope.name = data.data.first_name;
            $scope.surname = data.data.last_name;
            $scope.username = $scope.name + " " + $scope.surname;
            $scope.userPhone = data.data.phone;
            $scope.userEmail = data.data.email;
            $scope.userAddress = data.data.address.zip +
                " " +
                data.data.address.street +
                " " +
                data.data.address.rest;
            $http.get('/order/user/'+$scope.user_id).then(function (data) {
                $scope.orders = data.data;
            })
        }).catch(function (e) {
         alert("something has gone completely wrong. Try again please!")
         });
    });