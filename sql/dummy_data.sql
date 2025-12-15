USE boardmanager;

-- 회비 초기값
INSERT INTO dues_settings (current_dues) VALUES (500000);

-- 사용자 계정
INSERT INTO users (username, password, student_id, name, age, gender, birth_date, role) VALUES
('admin', 'admin1234', NULL, '교수님', 45, '남', '1980-03-15', 'admin'), -- 관리자
('president', 'pres1234', '2022001', '김용진', 22, '남', '2003-05-20', 'president'), -- 부장
('member1', 'mem1234', '2021001', '윤종현', 21, '남', '2004-08-10', 'member'), -- 회원들 
('member2', 'mem1234', '2022002', '김민수', 20, '남', '2005-11-05', 'member'),
('member3', 'mem1234', '2019001', '정진수', 23, '남', '2002-07-18', 'member'),
('member4', 'mem1234', '2021002', '노홍철', 21, '남', '2004-02-28', 'member'),
('member5', 'mem1234', '2022003', '차은우', 22, '남', '2003-09-30', 'member');

-- 스케줄
INSERT INTO schedules (schedule_date, location, member_count, description, participants, completed) VALUES
('2025-12-05', '학생회관 201호', 5, '보드게임 정기 모임', '윤종현,김민수,김민수,노홍철,차은우', FALSE), -- 진행 예정이므로 FALSE
('2025-12-10', '카페 투썸', 3, '임원진 회의', '김용진,윤종현,김민수', FALSE),
('2025-12-15', '학생회관', 6, '신입생 환영회', '김용진,윤종현,김민수,김민수,노홍철,차은우', FALSE);

-- 활동 내역
INSERT INTO activities (activity_date, location, member_count, description, participants) VALUES
('2025-11-15', '학생회관', 5, '보드게임 정기 모임', '김용진,윤종현,김민수,김민수,노홍철'),
('2025-11-20', '스터디 카페', 4, 'MT 준비 회의', '김용진,윤종현,김민수,김민수');

-- 회비 사용 내역
INSERT INTO dues (usage_date, location, representative, description, amount) VALUES
('2025-11-01', '보드게임 카페', '김용진', '보드게임 구입 (BANG!, 할리갈리)', 85000),
('2025-11-10', '문구점', '윤종현', '과자 및 음료', 25000),
('2025-11-20', '쿠X', '김민수', '횡령', 150000);


