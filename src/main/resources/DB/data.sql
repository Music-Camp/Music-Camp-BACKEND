INSERT INTO music.user (user_id, nickname, image_url, week, is_log,created_at,updated_at)
VALUES (1, 'aaron', 'https://www.ghibli.jp/gallery/totoro030.jpg','수',true,'2023-04-01 12:00:00','2023-04-01 12:00:00'),
       (2, 'baron', 'https://www.ghibli.jp/gallery/totoro031.jpg','수',true, '2023-04-01 12:00:00','2023-04-01 12:00:00'),
       (3, 'caron', 'https://www.ghibli.jp/gallery/totoro032.jpg','수',true, '2023-04-01 12:00:00','2023-04-01 12:00:00'),
       (4, 'daron', 'https://www.ghibli.jp/gallery/totoro033.jpg','수',true, '2023-04-01 12:00:00','2023-04-01 12:00:00'),
       (5, 'earon', 'https://www.ghibli.jp/gallery/totoro034.jpg','수',true, '2023-04-01 12:00:00','2023-04-01 12:00:00');



INSERT INTO music.post (post_id, user_id, title, content,image_url,created_at,updated_at)
VALUES (1,1, '완전 재미있어', '재미재미재미','https://www.ghibli.jp/gallery/totoro030.jpg','2023-04-01 12:00:00','2023-04-01 12:00:00'),
       (2,1, '우와오앙', '우와와오아와왕','https://www.ghibli.jp/gallery/totoro030.jpg', '2023-04-03 12:00:00','2023-04-01 12:00:00'),
       (3,1, '화이팅!', '행복힌 하루여라!','https://www.ghibli.jp/gallery/totoro030.jpg', '2023-04-05 12:00:00','2023-04-01 12:00:00'),
       (4,1, '자고 싶어', '잠 자고 싶다','https://www.ghibli.jp/gallery/totoro030.jpg', '2023-04-08 12:00:00','2023-04-01 12:00:00'),
       (5,1, '졸려', '졸려졸려졸려졸려졸려','https://www.ghibli.jp/gallery/totoro030.jpg', '2023-04-10 12:00:00','2023-04-01 12:00:00'),
       (6,1, 'to완전 재미있어', '재미재미재미','https://www.ghibli.jp/gallery/totoro030.jpg', '2023-04-01 12:00:00','2023-04-01 12:00:00'),
       (7,1, 'to우와오앙', '우와와오아와왕','https://www.ghibli.jp/gallery/totoro030.jpg', '2023-04-03 12:00:00','2023-04-01 12:00:00'),
       (8,1, '백설공주', '사과 맛있다','https://www.ghibli.jp/gallery/totoro030.jpg', '2023-04-05 12:00:00','2023-04-01 12:00:00'),
       (9,2, 'to자고 싶어', '잠 자고 싶다','https://www.ghibli.jp/gallery/totoro030.jpg', '2023-04-08 12:00:00','2023-04-01 12:00:00'),
       (10,2, 't0졸려', '졸려졸려졸려졸려졸려','https://www.ghibli.jp/gallery/totoro030.jpg', '2023-04-10 12:00:00','2023-04-01 12:00:00');


INSERT INTO music.comment (user_id, post_id, content, created_at) VALUES
                                                                      (1, 1, '이 글 정말 잘 읽었습니다.', '2023-04-01 12:00:00'),
                                                                      (2, 1, '매우 유익한 내용이에요!', '2023-04-01 12:00:00'),
                                                                      (3, 2, '충분히 공감되는 내용입니다.', '2023-04-01 12:00:00'),
                                                                      (4, 2, '정말 잘 쓰신 글 같아요.', '2023-04-01 12:00:00'),
                                                                      (5, 3, '많은 생각을 하게 만드는 글이네요.', '2023-04-01 12:00:00');