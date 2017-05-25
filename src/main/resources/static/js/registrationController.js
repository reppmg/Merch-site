/**
 * Created by Administrator on 24.05.2017.
 */
module
    .controller('registrationController', function ($scope, $http, $location, sharedProperties) {
        var path = $location.absUrl();

        function convertFormToJSON(form) {
            var array = jQuery(form).serializeArray();
            var json = {};
            json["address"] = {};
            var goodFields = ['zip', 'street', 'rest'];
                jQuery.each(array, function () {
                if (goodFields.indexOf(this.name) !== -1) {
                    json["address"][this.name] = this.value || ''
                } else {
                    json[this.name] = this.value || '';
                }
            });
            return json;
        }

        $scope.post = function () {
            var s = $("#registration");
            var user = convertFormToJSON(s);
            user["user_id"] = sharedProperties.getProperty();
            $http.post('/user', user).then(alert("Success"))

        }

    });