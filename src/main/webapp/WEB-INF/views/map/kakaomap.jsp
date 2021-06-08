<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>다음 지도 API</title>
</head>
<body>
	<div id="map" style="width: 750px; height: 350px;"></div>

	<script
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=807012f1e6a8a9a9120deb6eef944974&libraries=clusterer"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.66887, 127.76494), // 지도의 중심좌표
			level : 11, // 지도의 확대 레벨
			mapTypeId : kakao.maps.MapTypeId.ROADMAP
		// 지도종류
		};
		// 지도를 생성한다 
		var map = new kakao.maps.Map(mapContainer, mapOption);

		var clusterer = new kakao.maps.MarkerClusterer({
			map : map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
			averageCenter : true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
			minLevel : 10
		// 클러스터 할 최소 지도 레벨 
		});
		// 마커 이미지의 주소
		var markerImageUrl = 'https://t1.daumcdn.net/localimg/localimages/07/2012/img/marker_p.png', markerImageSize = new kakao.maps.Size(
				40, 42), // 마커 이미지의 크기
		markerImageOptions = {
			offset : new kakao.maps.Point(20, 42)
		// 마커 좌표에 일치시킬 이미지 안의 좌표
		};
		var infodata = [
				[ 37.52844, 127.13881,
						'<div style="padding:5px;">코로나정보 1</div>' ],
				[ 37.52244, 127.13381,
						'<div style="padding:5px;">코로나정보 2</div>' ],
				[ 37.52444, 127.13481,
						'<div style="padding:5px;">코로나정보 3</div>' ],
				[ 37.52244, 127.13381,
						'<div style="padding:5px;">코로나정보 2</div>' ],
				[ 37.52244, 127.13381,
						'<div style="padding:5px;">코로나정보 2</div>' ],
				[ 37.52244, 127.13381,
						'<div style="padding:5px;">코로나정보 2</div>' ],
				[ 37.52244, 127.13381,
						'<div style="padding:5px;">코로나정보 2</div>' ],
				[ 37.52244, 127.13381,
						'<div style="padding:5px;">코로나정보 2</div>' ],
				[ 37.52244, 127.13381,
						'<div style="padding:5px;">코로나정보 2</div>' ],
				[ 37.52244, 127.13381,
						'<div style="padding:5px;">코로나정보 2</div>' ]

		];
		var markers = [];
		// 마커 이미지를 생성한다
		var markerImage = new kakao.maps.MarkerImage(markerImageUrl,
				markerImageSize, markerImageOptions);
		// 지도에 마커를 생성하고 표시한다
		for (var i = 0; i < infodata.length; i++) {
			var marker = new kakao.maps.Marker(
					{
						position : new kakao.maps.LatLng(infodata[i][0],
								infodata[i][1]), // 마커의 좌표
						image : markerImage, // 마커의 이미지
						map : map
					// 마커를 표시할 지도 객체
					});
			// 마커 위에 표시할 인포윈도우를 생성한다
			var infowindow = new kakao.maps.InfoWindow({
				content : infodata[i][2]
			// 인포윈도우에 표시할 내용
			});

			// 인포윈도우를 지도에 표시한다

			markers.push(marker);
			kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(
					map, marker, infowindow));
			kakao.maps.event.addListener(marker, 'mouseout',
					makeOutListener(infowindow));
		}

		clusterer.addMarkers(markers);

		function makeOverListener(map, marker, infowindow) {
			return function() {
				infowindow.open(map, marker);
			};
		}

		// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		function makeOutListener(infowindow) {
			return function() {
				infowindow.close();
			};
		}
	</script>
</body>
</html>