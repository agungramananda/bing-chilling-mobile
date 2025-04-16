import { View, Text, StyleSheet, TouchableOpacity, Image, ScrollView } from 'react-native';
import { Settings, CreditCard, Gift, History, ChevronRight } from 'lucide-react-native';

const MENU_ITEMS = [
  {
    id: '1',
    title: 'Order History',
    icon: History,
  },
  {
    id: '2',
    title: 'Payment Methods',
    icon: CreditCard,
  },
  {
    id: '3',
    title: 'Rewards',
    icon: Gift,
  },
  {
    id: '4',
    title: 'Settings',
    icon: Settings,
  },
];

export default function ProfileScreen() {
  return (
    <ScrollView style={styles.container}>
      <View style={styles.header}>
        <View style={styles.profileSection}>
          <Image
            source={{ uri: 'https://images.unsplash.com/photo-1494790108377-be9c29b29330?w=200&h=200&fit=crop' }}
            style={styles.profileImage}
          />
          <View style={styles.profileInfo}>
            <Text style={styles.name}>Sarah Johnson</Text>
            <Text style={styles.email}>sarah.j@example.com</Text>
          </View>
        </View>
      </View>

      <View style={styles.rewardsCard}>
        <Text style={styles.rewardsTitle}>Rewards Points</Text>
        <Text style={styles.rewardsPoints}>2,450</Text>
        <TouchableOpacity style={styles.rewardsButton}>
          <Text style={styles.rewardsButtonText}>View Rewards</Text>
        </TouchableOpacity>
      </View>

      <View style={styles.menuSection}>
        {MENU_ITEMS.map((item) => (
          <TouchableOpacity key={item.id} style={styles.menuItem}>
            <View style={styles.menuItemLeft}>
              <item.icon size={24} color="#666" />
              <Text style={styles.menuItemText}>{item.title}</Text>
            </View>
            <ChevronRight size={24} color="#666" />
          </TouchableOpacity>
        ))}
      </View>

      <TouchableOpacity style={styles.logoutButton}>
        <Text style={styles.logoutButtonText}>Log Out</Text>
      </TouchableOpacity>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
  header: {
    backgroundColor: '#FF1493',
    padding: 20,
    paddingTop: 60,
    paddingBottom: 30,
  },
  profileSection: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  profileImage: {
    width: 80,
    height: 80,
    borderRadius: 40,
    borderWidth: 3,
    borderColor: '#fff',
  },
  profileInfo: {
    marginLeft: 15,
  },
  name: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#fff',
  },
  email: {
    fontSize: 14,
    color: '#fff',
    opacity: 0.8,
  },
  rewardsCard: {
    margin: 20,
    padding: 20,
    backgroundColor: '#fff',
    borderRadius: 12,
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.1,
    shadowRadius: 8,
    elevation: 3,
  },
  rewardsTitle: {
    fontSize: 18,
    color: '#333',
    fontWeight: '600',
  },
  rewardsPoints: {
    fontSize: 36,
    fontWeight: 'bold',
    color: '#FF1493',
    marginVertical: 10,
  },
  rewardsButton: {
    backgroundColor: '#FF1493',
    padding: 12,
    borderRadius: 8,
    alignItems: 'center',
    marginTop: 10,
  },
  rewardsButtonText: {
    color: '#fff',
    fontSize: 16,
    fontWeight: '600',
  },
  menuSection: {
    paddingHorizontal: 20,
  },
  menuItem: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    paddingVertical: 15,
    borderBottomWidth: 1,
    borderBottomColor: '#f0f0f0',
  },
  menuItemLeft: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  menuItemText: {
    fontSize: 16,
    color: '#333',
    marginLeft: 15,
  },
  logoutButton: {
    margin: 20,
    padding: 15,
    backgroundColor: '#f0f0f0',
    borderRadius: 8,
    alignItems: 'center',
  },
  logoutButtonText: {
    color: '#FF1493',
    fontSize: 16,
    fontWeight: '600',
  },
});