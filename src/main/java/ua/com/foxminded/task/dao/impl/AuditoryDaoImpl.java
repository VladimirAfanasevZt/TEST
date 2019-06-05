package ua.com.foxminded.task.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.task.dao.AuditoryDao;
import ua.com.foxminded.task.dao.AuditoryTypeDao;
import ua.com.foxminded.task.dao.DaoFactory;
import ua.com.foxminded.task.domain.Auditory;
import ua.com.foxminded.task.domain.AuditoryType;

public class AuditoryDaoImpl implements AuditoryDao {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public boolean create(Auditory auditory) {
        String sql = "insert into auditories (number, auditory_type_id, capacity, description) values (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isCreate = false;

        try {
            connection = daoFactory.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, auditory.getAuditoryNumber());
            preparedStatement.setInt(2, auditory.getType().getId());
            preparedStatement.setInt(3, auditory.getMaxCapacity());
            preparedStatement.setString(4, auditory.getDescription());
            isCreate = preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            daoFactory.closePreparedStatement(preparedStatement);
            daoFactory.closeConnection(connection);
        }
        return isCreate;
    }

    @Override
    public Auditory findById(int id) {
        String sql = "select * from auditories a inner join auditory_types at on a.auditory_type_id = at.id where a.id=?";
        Auditory auditory = null;
        AuditoryType auditoryType = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                auditory = new Auditory();
                auditory.setId(resultSet.getInt("a.id"));
                auditory.setAuditoryNumber(resultSet.getString("a.number"));
                auditory.setMaxCapacity(resultSet.getInt("a.capacity"));
                auditory.setDescription(resultSet.getString("a.description"));
                auditoryType = new AuditoryType();
                auditoryType.setId(resultSet.getInt("at.id"));
                auditoryType.setType(resultSet.getString("at.type"));
                auditory.setType(auditoryType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            daoFactory.closeResultSet(resultSet);
            daoFactory.closePreparedStatement(preparedStatement);
            daoFactory.closeConnection(connection);
        }
        return auditory;
    }

    @Override
    public List<Auditory> findAll() {
        String sql = "select * from auditories a inner join auditory_types at on a.auditory_type_id = at.id";
        Auditory auditory = null;
        AuditoryType auditoryType = null;
        List<Auditory> auditories = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = daoFactory.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                auditory = new Auditory();
                auditory.setId(resultSet.getInt("a.id"));
                auditory.setAuditoryNumber(resultSet.getString("a.number"));
                auditory.setMaxCapacity(resultSet.getInt("a.capacity"));
                auditory.setDescription(resultSet.getString("a.description"));
                auditoryType = new AuditoryType();
                auditoryType.setId(resultSet.getInt("at.id"));
                auditoryType.setType(resultSet.getString("at.type"));
                auditory.setType(auditoryType);
                auditories.add(auditory);
                System.out.println(auditory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            daoFactory.closeResultSet(resultSet);
            daoFactory.closePreparedStatement(preparedStatement);
            daoFactory.closeConnection(connection);
        }
        return auditories;
    }

    @Override
    public Auditory findByNumber(String number) {
        String sql = "select * from auditories where number=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Auditory auditory = null;
        AuditoryType auditoryType = null;
        int auditoryTypeId = 0;

        try {
            connection = daoFactory.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, number);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                auditory = new Auditory();
                auditory.setId(resultSet.getInt("id"));
                auditory.setAuditoryNumber(resultSet.getString("number"));
                auditory.setMaxCapacity(resultSet.getInt("capacity"));
                auditory.setDescription(resultSet.getString("description"));
                auditoryTypeId = resultSet.getInt("auditory_type_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            daoFactory.closeResultSet(resultSet);
            daoFactory.closePreparedStatement(preparedStatement);
            daoFactory.closeConnection(connection);
        }
        AuditoryTypeDao auditoryTypeDao = new AuditoryTypeDaoImpl();
        auditoryType = auditoryTypeDao.findById(auditoryTypeId);
        auditory.setType(auditoryType);

        return auditory;
    }

}
