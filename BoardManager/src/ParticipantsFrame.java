import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import java.sql.*;
import java.util.ArrayList;

public class ParticipantsFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ParticipantsFrame.class.getName());

    private int scheduleId;
    private DefaultListModel<String> allMemberModel;     // 전체 회원 목록 모델
    private DefaultListModel<String> partMemberModel;    // 참가 인원 목록 모델
    private ArrayList<String> allMemberNames;            // 전체 회원 이름 목록
    private ArrayList<String> partMemberNames;           // 참가 회원 이름 목록

    public ParticipantsFrame(int scheduleId) {
        this.scheduleId = scheduleId;//스케줄 아이디를 가져옴
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//MainFrame이 안 닫히게 함

        // 리스트 모델 초기화
        allMemberModel = new DefaultListModel<>();
        partMemberModel = new DefaultListModel<>();
        allMemberNames = new ArrayList<>();
        partMemberNames = new ArrayList<>();

        // 참여 인원 리스트에 빈 모델 설정 (기본값: 비어있음)
        jList2.setModel(partMemberModel);

        loadMemberList(); //전체 회원 목록 로드

        // scheduleId가 유효한 경우에만 기존 참가자 로드
        if (scheduleId > 0) {
            loadExistingParticipants(); //기존 참가자 로드 (수정 모드용)
        }
    }

    /**
     * DB에서 전체 회원 목록 로드
     */
    public void loadMemberList() {
        allMemberModel.clear();
        allMemberNames.clear();

        String sql = "SELECT name FROM users ORDER BY name";

        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");

                allMemberModel.addElement(name); // 이름만 표시
                allMemberNames.add(name); // 이름 저장
            }

            lstAllMember.setModel(allMemberModel);

        } catch (SQLException e) {
            System.err.println("회원 목록 로드 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 기존 참가자 목록 로드 (스케줄 수정 시)
     */
    private void loadExistingParticipants() {
        String sql = "SELECT participants FROM schedules WHERE id=?";

        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, scheduleId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String participants = rs.getString("participants");
                if (participants != null && !participants.isEmpty()) {
                    String[] names = participants.split(",");
                    for (String name : names) {
                        String trimmedName = name.trim();
                        partMemberModel.addElement(trimmedName);
                        partMemberNames.add(trimmedName);
                    }
                    jList2.setModel(partMemberModel);
                }
            }

        } catch (SQLException e) {
            System.err.println("기존 참가자 로드 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        btnPartInsert = new javax.swing.JButton();
        btnPartDelete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstAllMember = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        lstPartMember = new javax.swing.JLabel();
        btnPartSave = new javax.swing.JButton();
        btnPartQuit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        btnPartInsert.setText("추가");
        btnPartInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartInsertActionPerformed(evt);
            }
        });

        btnPartDelete.setText("삭제");
        btnPartDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartDeleteActionPerformed(evt);
            }
        });

        lstAllMember.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(lstAllMember);

        jLabel1.setText("전체 인원");

        lstPartMember.setText("참여 인원");

        btnPartSave.setText("저장");
        btnPartSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartSaveActionPerformed(evt);
            }
        });

        btnPartQuit.setText("나가기");
        btnPartQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartQuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPartQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnPartInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPartSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPartDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lstPartMember)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lstPartMember))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPartInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPartDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPartSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPartQuit)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //추가 버튼
    private void btnPartInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartInsertActionPerformed
        // 전체 회원 목록에서 선택된 항목 가져오기
        int selectedIndex = lstAllMember.getSelectedIndex();
        if (selectedIndex == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "추가할 회원을 선택해주세요.");
            return;
        }

        String selectedName = allMemberNames.get(selectedIndex);

        // 이미 참가자 목록에 있는지 확인
        if (partMemberNames.contains(selectedName)) {
            javax.swing.JOptionPane.showMessageDialog(this, "이미 참가자 목록에 있습니다.");
            return;
        }

        // 참가자 목록에 추가 (이름만 표시)
        partMemberModel.addElement(selectedName);
        partMemberNames.add(selectedName);
        jList2.setModel(partMemberModel); // 모델 업데이트
    }//GEN-LAST:event_btnPartInsertActionPerformed

    //삭제 버튼
    private void btnPartDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartDeleteActionPerformed
        // 참가자 목록에서 선택된 항목 제거
        int selectedIndex = jList2.getSelectedIndex();
        if (selectedIndex == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "제거할 참가자를 선택해주세요.");
            return;
        }

        partMemberModel.remove(selectedIndex);
        partMemberNames.remove(selectedIndex);
        jList2.setModel(partMemberModel); // 모델 업데이트
    }//GEN-LAST:event_btnPartDeleteActionPerformed

    //저장 버튼
    private void btnPartSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartSaveActionPerformed
        // 참가자 목록을 쉼표로 구분된 문자열로 변환 (이름 저장)
        StringBuilder participants = new StringBuilder();
        for (int i = 0; i < partMemberNames.size(); i++) {
            if (i > 0) {
                participants.append(",");
            }
            participants.append(partMemberNames.get(i));
        }

        // DB 업데이트
        String sql = "UPDATE schedules SET participants=?, member_count=? WHERE id=?";

        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, participants.toString());
            pstmt.setInt(2, partMemberNames.size());
            pstmt.setInt(3, scheduleId);

            int affected = pstmt.executeUpdate();
            if (affected > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "참가자 정보가 저장되었습니다!");

                // MainFrame의 스케줄 테이블 새로고침
                refreshMainFrame();

                dispose(); // 창 닫기
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "저장에 실패했습니다.");
            }

        } catch (SQLException e) {
            System.err.println("참가자 저장 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }//GEN-LAST:event_btnPartSaveActionPerformed

    /**
     * MainFrame의 스케줄 테이블 새로고침
     */
    private void refreshMainFrame() {
        // 모든 열린 프레임 중 MainFrame 찾기
        for (java.awt.Frame frame : java.awt.Frame.getFrames()) {
            if (frame instanceof MainFrame) {
                ((MainFrame) frame).loadScheduleTable();
                break;
            }
        }
    }
    
    //나가기 버튼
    private void btnPartQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartQuitActionPerformed
        dispose(); // 창 닫기
    }//GEN-LAST:event_btnPartQuitActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPartDelete;
    private javax.swing.JButton btnPartInsert;
    private javax.swing.JButton btnPartQuit;
    private javax.swing.JButton btnPartSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> lstAllMember;
    private javax.swing.JLabel lstPartMember;
    // End of variables declaration//GEN-END:variables
}
