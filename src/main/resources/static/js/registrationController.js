/**
 * Created by Administrator on 24.05.2017.
 */
module
    .controller('registrationController', function ($scope, $http, $location, sharedProperties) {

        $http.get('/user').then(function (data) {
            $scope.user_id = data.data.uid;
            if (data.data.registered) {
                window.location.replace("/");
                // $scope.$apply($location.path("/home"));
            }
            $scope.name = data.data.first_name;
            $scope.surname = data.data.last_name;
            $scope.username = $scope.name + " " + $scope.surname;
        }).catch(function (e) {
            alert("something has gone completely wrong. Try again please!")
        });
        var path = $location.absUrl();

        $scope.useSavedAddress = true;

        $scope.changeUsingSavedAddress = function () {
            $scope.useSavedAddress = !$scope.useSavedAddress;
        };

        function convertFormToJSON(form) {
            var array = jQuery(form).serializeArray();
            var json = {};
            json["address"] = {};
            var goodFields = ['zip', 'street', 'rest'];
            jQuery.each(array, function () {
                if (goodFields.indexOf(this.name) !== -1) {
                    json["address"][this.name] = this.value || ''
                    if ($scope.useSavedAddress) json["address"][this.name] = '';
                } else {
                    json[this.name] = this.value || '';
                }
            });
            return json;
        }

        $scope.post = function () {
            var s = $("#registration");
            var user = convertFormToJSON(s);
            user["id"] = $scope.user_id;
            user["name"] = $scope.name;
            user["surname"] = $scope.surname;
            $http.post('/user', user).then(window.location.replace("/"))

        }

    });