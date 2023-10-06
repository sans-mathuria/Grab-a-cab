<body>
    <h1>Unique Destination</h1>
    <div id="unique-sources"></div>
    <div id="global-variable"></div>
    <div id="global-variable-type"></div>
    <canvas id="pie-chart" width="200" height="200"></canvas>

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            var uniqueSourcesCount;

            $.get("/unique-sources1/count", function(data) {
                uniqueSourcesCount = data;
                $("#global-variable").text("Global variable value: " + uniqueSourcesCount);
                // Create a pie chart using Chart.js
                var ctx = document.getElementById("pie-chart").getContext("2d");
                var dataPoints = [];
                for(var i=0;i<uniqueSourcesCount.length;i++)
                {
                    dataPoints.push(uniqueSourcesCount[i]);
                }
                var chart = new Chart(ctx, {
                    type: "pie",
                    data: {
                        datasets: [{
                            data: dataPoints,
                            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"]
                        }]
                    },
                    options: {
                        title: {
                            display: true,
                            text: "Distribution of Unique Sources"
                        }
                    }
                });
            });
            
        });
    </script>
</body>
